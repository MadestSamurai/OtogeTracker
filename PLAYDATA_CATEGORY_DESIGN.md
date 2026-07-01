# PlayData 多分类方式设计说明

## 概述
为 PlayDataList 组件增加了四种分类方式：
1. **难度分类**（DIFFICULTY）：Basic/Advanced/Expert/Master/Ultima
2. **类型分类**（GENRE）：POPS & ANIME, niconico, 東方Project 等
3. **版本分类**（VERSION）：CHUNITHM, AIR, STAR, AMAZON 等
4. **定数分类**（LEVEL）：按难度数值范围分组（1-5, 6-10, 11-12, 12+, 13, 13+, 14, 14+, 15）

## 架构设计

### 1. 数据模型（ChunithmPlayDataCategory.kt）
```kotlin
enum class PlayDataCategoryType {
    DIFFICULTY,  // 难度分类
    GENRE,       // 类型分类
    VERSION,     // 版本分类
    LEVEL        // 定数分类
}

data class PlayDataCategory(
    val type: PlayDataCategoryType,
    val name: String,          // 显示名称
    val key: String,           // 查询键
    val color: Color? = null   // 可选颜色
)

data class PlayDataCategoryStats(
    val category: PlayDataCategory,
    val totalSongs: Int,
    val rateSSSp: Int,
    val rateSSS: Int,
    // ... 其他统计数据
)
```

### 2. 分类提供者（ChunithmPlayDataCategoryProvider.kt）
提供各分类方式的分类列表：

#### Genre 分类（8个）
- POPS & ANIME
- niconico
- 東方Project
- VARIETY
- イロドリミドリ
- ゲキマイ
- ORIGINAL
- WORLD'S END

#### Version 分类（16个）
- LUMINOUS（最新）
- SUN PLUS
- SUN
- NEW PLUS
- NEW
- PARADISE LOST
- PARADISE
- CRYSTAL PLUS
- CRYSTAL
- AMAZON PLUS
- AMAZON
- STAR PLUS
- STAR
- AIR PLUS
- AIR
- CHUNITHM（初代）

#### Level 分类（9个范围）
- 15（15.0-15.9）
- 14+（14.7-14.9）
- 14（14.0-14.6）
- 13+（13.7-13.9）
- 13（13.0-13.6）
- 12+（12.7-12.9）
- 11-12（11.0-12.6）
- 6-10（6.0-10.9）
- 1-5（1.0-5.9）

### 3. UI 组件

#### PlayDataCategorySelector（分类选择器）
四个按钮切换分类方式：
- 难度
- 类型
- 版本
- 定数

选中状态：红色背景 + 白色文字
未选中状态：半透明背景 + 米色文字

#### PlayDataList（主组件）
- 顶部：标题 + 分类类型提示 + 难度标签（难度模式） + 详细按钮
- 中间：分类选择器（4个按钮）
- 底部：横向分页器显示各分类的数据卡片

### 4. 当前实现状态
✅ 数据模型完成
✅ 分类提供者完成
✅ UI 组件完成
✅ 难度分类可用（使用现有数据）
⏳ Genre/Version/Level 分类：UI 占位符已就绪，等待 ViewModel 提供数据

## 下一步实现建议

### 在 ChunithmViewModel 中添加统计方法：

```kotlin
// 按类型统计
fun loadPlayDataByGenre(): StateFlow<List<PlayDataCategoryStats>> {
    viewModelScope.launch {
        val allScores = chunithmLocalService.getAllFullScores()
        val allSongs = chunithmLocalService.getAllSongs()

        val genreStats = ChunithmPlayDataCategoryProvider.getGenreCategories()
            .map { category ->
                val genreSongs = allSongs.filter { it.genre == category.key }
                val genreScores = allScores.filter { score ->
                    genreSongs.any { it.title == score.title }
                }

                PlayDataCategoryStats(
                    category = category,
                    totalSongs = genreSongs.size,
                    rateSSSp = genreScores.count { it.rank >= 13 },
                    // ... 计算其他统计
                )
            }

        _playDataByGenre.value = genreStats
    }
}

// 按版本统计
fun loadPlayDataByVersion(): StateFlow<List<PlayDataCategoryStats>>

// 按定数统计
fun loadPlayDataByLevel(): StateFlow<List<PlayDataCategoryStats>>
```

### 数据计算逻辑

1. **类型分类**：
   - 从 ChunithmSongsEntity 获取所有歌曲的 genre 字段
   - 匹配 ChunithmFullScoreEntity 中的成绩
   - 按类型聚合统计

2. **版本分类**：
   - 从 ChunithmSongsEntity 获取所有歌曲的 version 字段
   - 匹配成绩数据
   - 按版本聚合统计

3. **定数分类**：
   - 从 ChunithmSheetsEntity 获取所有谱面的 levelValueCn 字段
   - 根据定数范围分组（如 14.0-14.6 为 "14"）
   - 匹配成绩数据
   - 按定数范围聚合统计

### 聚合统计项

对每个分类需要统计：
- `totalSongs`: 该分类下的总曲目数
- `rateSSSp, rateSSS, ...`: 各评级达成数量
- `rateClear, rateHard, ...`: 各通关类型达成数量
- `rateFC, rateAJ, ...`: FC/AJ 等达成数量
- `scoreTotal`: 总分数（所有最高分之和）

## 使用示例

```kotlin
// 在 ChunithmRecordPage 中
PlayDataList(
    width = width,
    chunithmPlayDataUiModel = viewModel.chunithmPlayDataUiModel
)
```

用户可以点击"难度"、"类型"、"版本"、"定数"按钮切换分类方式，
横向滑动查看各分类的详细数据统计。

## 注意事项

1. **数据一致性**：确保 ChunithmSongsEntity.genre 和 ChunithmFullScoreEntity.genre 字段一致
2. **版本名称**：version 字段格式需要与 VersionCategories 中的 key 匹配
3. **定数计算**：使用 CN 服定数（levelValueCn），需要处理 null 值
4. **性能优化**：考虑缓存统计结果，避免重复计算
5. **WORLD'S END**：特殊类型，可能需要特殊处理逻辑

## 扩展性

该设计支持轻松添加新的分类方式：
1. 在 `PlayDataCategoryType` 添加新枚举
2. 在 `ChunithmPlayDataCategoryProvider` 添加新分类列表
3. 在 `PlayDataCategorySelector` 添加新按钮
4. 在 ViewModel 实现对应的统计方法
