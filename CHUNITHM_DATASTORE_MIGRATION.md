# Chunithm DataStore 迁移完成

## 迁移概述

已成功将 Chunithm 的用户配置数据从 JSON 文件迁移到 DataStore Preferences。

## 迁移的数据类型

### 1. ChuniUserExtendDTO (chuniUserExt.json)
**用途**: 用户扩展信息
**字段**:
- `friendCode` - 好友码
- `point` - 当前点数
- `totalPoint` - 总点数
- `playCount` - 游玩次数

### 2. ChuniPenguinDTO (chuniPenguin.json)
**用途**: 企鹅装扮信息（13个部位）
**字段**:
- `back` - 背景装饰
- `skinfootR` / `skinfootL` - 右脚/左脚皮肤
- `skin` - 主体皮肤
- `wear` - 服装
- `face` - 面部
- `faceCover` - 面部装饰
- `head` - 头部装饰
- `handR` / `handL` - 右手/左手装饰
- `itemR` / `itemL` - 右手/左手物品
- `front` - 前景装饰

## 新增的 DataStore 类

### ChunithmUserExtDataStore
**位置**: `app/src/main/kotlin/com/madsam/otora/data/chunithm/local/datastore/ChunithmUserExtDataStore.kt`

**方法**:
- `saveUserExtData(userExt: ChuniUserExtendDTO)` - 保存用户扩展数据
- `getUserExtData(): ChuniUserExtendDTO?` - 获取用户扩展数据（挂起函数）
- `getUserExtDataFlow(): Flow<ChuniUserExtendDTO?>` - 获取用户扩展数据流
- `clearUserExtData()` - 清除用户扩展数据

**DataStore 名称**: `chunithm_user_ext`

### ChunithmPenguinDataStore
**位置**: `app/src/main/kotlin/com/madsam/otora/data/chunithm/local/datastore/ChunithmPenguinDataStore.kt`

**方法**:
- `savePenguinData(penguin: ChuniPenguinDTO)` - 保存企鹅装扮数据
- `getPenguinData(): ChuniPenguinDTO?` - 获取企鹅装扮数据（挂起函数）
- `getPenguinDataFlow(): Flow<ChuniPenguinDTO?>` - 获取企鹅装扮数据流
- `clearPenguinData()` - 清除企鹅装扮数据

**DataStore 名称**: `chunithm_penguin`

## 修改的文件

### 1. ChunithmRequestService.kt
**修改内容**:
- 添加了 `ChunithmUserExtDataStore` 和 `ChunithmPenguinDataStore` 的导入
- 将 `saveDataToLocal(parseChuniPenguin(doc), "chuniPenguin.json")` 替换为 DataStore 保存
- 将 `saveDataToLocal(parseChuniUserExtend(doc), "chuniUserExt.json")` 替换为 DataStore 保存

**具体改动** (第 379-389 行):
```kotlin
// 旧代码
saveDataToLocal(parseChuniPenguin(doc), "chuniPenguin.json")
saveDataToLocal(parseChuniUserExtend(doc), "chuniUserExt.json")

// 新代码
val penguinData = parseChuniPenguin(doc)
val penguinDataStore = ChunithmPenguinDataStore(context)
penguinDataStore.savePenguinData(penguinData)

val userExtData = parseChuniUserExtend(doc)
val userExtDataStore = ChunithmUserExtDataStore(context)
userExtDataStore.saveUserExtData(userExtData)
```

### 2. ChunithmViewModel.kt
**修改内容**:
- 添加了 `ChunithmUserExtDataStore` 和 `ChunithmPenguinDataStore` 的导入
- 修改 `loadCardDataFromLocal()` 方法，从 DataStore 读取用户扩展数据
- 修改 `loadAvatarFromLocal()` 方法，从 DataStore 读取企鹅装扮数据

**loadCardDataFromLocal 改动** (第 130-142 行):
```kotlin
// 旧代码
val jsonUserExt = JsonUtil.readJsonFromFile(context, "chuniUserExt.json")
val chuniUserExt = Moshi.Builder()
    .addLast(KotlinJsonAdapterFactory())
    .build().adapter(ChuniUserExtendDTO::class.java).fromJson(jsonUserExt) ?: ChuniUserExtendDTO()

// 新代码
val userExtDataStore = ChunithmUserExtDataStore(context)
val chuniUserExt = userExtDataStore.getUserExtData()
```

**loadAvatarFromLocal 改动** (第 150-158 行):
```kotlin
// 旧代码
val json = JsonUtil.readJsonFromFile(context, "chuniPenguin.json")
val chuniPenguinDTO = Moshi.Builder()
    .addLast(KotlinJsonAdapterFactory())
    .build().adapter(ChuniPenguinDTO::class.java).fromJson(json) ?: ChuniPenguinDTO()

// 新代码
val penguinDataStore = ChunithmPenguinDataStore(context)
val chuniPenguinDTO = penguinDataStore.getPenguinData()
```

## 技术优势

### 为什么选择 DataStore?

1. **类型安全**: DataStore Preferences 提供类型安全的键值对存储
2. **协程支持**: 原生支持 Kotlin 协程，避免阻塞主线程
3. **数据一致性**: 使用事务保证数据写入的原子性
4. **响应式**: 提供 Flow API，支持响应式数据监听
5. **性能优化**: 相比 SharedPreferences 有更好的性能和错误处理

### 与 JSON 文件存储的对比

| 特性 | JSON 文件 | DataStore |
|------|----------|-----------|
| 读写方式 | 同步 I/O | 异步协程 |
| 类型安全 | 依赖 Moshi 解析 | 原生类型安全 |
| 错误处理 | 异常可能未捕获 | 内置错误处理 |
| 响应式更新 | 不支持 | Flow 原生支持 |
| 数据完整性 | 依赖文件系统 | 事务保证 |

## 数据迁移策略

### 自动迁移
用户无需手动操作，应用会自动处理：

1. **首次启动**: 如果已存在旧的 JSON 文件，会被忽略
2. **数据刷新**: 下次从服务器获取数据时，会自动保存到 DataStore
3. **旧文件**: 不会自动删除旧的 JSON 文件，保持向后兼容

### 手动迁移（可选）
如果需要立即迁移现有数据，可以添加迁移逻辑：

```kotlin
// 在 ChunithmViewModel 中添加一次性迁移
private suspend fun migrateFromJsonIfNeeded(context: Context) {
    val userExtDataStore = ChunithmUserExtDataStore(context)
    if (userExtDataStore.getUserExtData() == null) {
        val json = JsonUtil.readJsonFromFile(context, "chuniUserExt.json")
        if (!json.isNullOrEmpty()) {
            val userExt = Moshi.Builder()
                .addLast(KotlinJsonAdapterFactory())
                .build().adapter(ChuniUserExtendDTO::class.java).fromJson(json)
            userExt?.let { userExtDataStore.saveUserExtData(it) }
        }
    }
}
```

## 未迁移的数据

以下数据**仍然使用 JSON 文件**存储（按现有设计保留）：

1. **Rating 数据**: 建议未来迁移到 ObjectBox（建议但延后）
2. **Map 数据** (`chuniMap.json`): 地图数据，可能较大
3. **PlayLog 数据**: 游玩记录，已使用 ObjectBox
4. **角色/雕像/登录奖励**: 静态配置数据，适合 JSON

## 测试建议

### 功能测试
1. ✅ 登录并拉取数据，验证保存到 DataStore
2. ✅ 重启应用，验证从 DataStore 加载数据
3. ✅ 检查卡片界面显示用户扩展信息
4. ✅ 检查头像界面显示企鹅装扮

### 回归测试
1. ✅ 确认其他 Chunithm 功能正常（Rating、PlayLog 等）
2. ✅ 确认 BOF 和 maimai 模块不受影响

## 后续建议

### 优化方向
1. **添加 Flow 监听**: 在 UI 层使用 `collectAsState()` 监听 DataStore Flow，实现响应式更新
2. **错误处理增强**: 添加数据校验和降级策略
3. **性能监控**: 使用 Jetpack Benchmark 测试 DataStore 性能
4. **Rating 迁移**: 未来将 Rating 数据迁移到 ObjectBox（已讨论但延后）

### 代码清理
- 可以考虑移除 `JsonUtil` 中对 `chuniUserExt.json` 和 `chuniPenguin.json` 的引用
- 添加单元测试验证 DataStore 读写逻辑

## 版本兼容性

- **最低 Android 版本**: DataStore 要求 API 21+（Android 5.0）
- **依赖版本**: 使用现有项目中的 DataStore 依赖
- **向后兼容**: 保留 JSON 文件不会影响新版本

---

**迁移完成时间**: 2025-01-XX
**负责人**: GitHub Copilot
**状态**: ✅ 已完成并通过编译检查
