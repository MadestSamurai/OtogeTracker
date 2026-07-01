# CHUNITHM Avatar 自定义部件功能实现

## 功能概述
实现了CHUNITHM游戏中Avatar自定义部件的数据解析、存储和展示功能。

## 实现内容

### 1. 数据模型层

#### Entity（数据库实体）
- **文件**: `ChunithmAvatarItemEntity.kt`
- **功能**: ObjectBox数据库实体，存储Avatar部件信息
- **字段**:
  - `id`: 自增主键
  - `itemId`: 部件ID（来自服务器的idx）
  - `name`: 部件名称
  - `category`: 部件类型（face/head/wear/item/back/front）
  - `imageUrl`: 部件图片URL
  - `isCurrentlyUsed`: 是否正在使用
  - `token`: 用于设置的token
  - `syncedAt`: 同步时间戳

#### DTO（数据传输对象）
- **文件**: `ChunithmAvatarItemDTO.kt`
- **功能**: 用于API响应和服务层之间的数据传输

### 2. 数据访问层（ObjectBox Service）

**文件**: `ChunithmObjectBoxService.kt`

新增方法：
- `saveAvatarItems(items, category)`: 保存Avatar部件数据，支持按类型替换
- `getAvatarItemsByCategory(category)`: 获取指定类型的部件列表
- `getAllAvatarItems()`: 获取所有部件（按类型和名称排序）
- `getCurrentAvatarItems(category)`: 获取当前使用的部件

### 3. 网络请求层（Request Service）

**文件**: `ChunithmRequestService.kt`

新增方法：

#### 解析方法
- `parseAvatarItems(doc, category)`: 解析HTML页面中的Avatar部件列表
- `parseAvatarItemBlock(block, category, isCurrentlyUsed)`: 解析单个部件块

#### 请求方法
- `requestAvatarItems(category)`: 请求指定类型的Avatar部件
- `requestAllAvatarItems(onProgress)`: 请求所有6种类型的Avatar部件

#### 集成点
- 已集成到 `getUserData()` 方法中，在用户数据同步时自动获取Avatar部件数据

### 4. UI展示层

#### ViewModel
**文件**: `ChunithmViewModel.kt`

新增状态：
- `avatarItems`: Avatar部件列表
- `selectedAvatarCategory`: 当前选中的类型
- `isAvatarItemsLoading`: 加载状态

新增方法：
- `loadAvatarItems(category)`: 加载指定类型的部件
- `selectAvatarCategory(category)`: 切换部件类型
- `loadAllAvatarItems()`: 加载所有部件

#### 页面组件
**文件**: `ChunithmAvatarListPage.kt`

功能特性：
- 顶部工具栏（返回按钮、标题、统计）
- 分类筛选栏（6个类型的FilterChip）
- 网格布局展示部件
- 加载状态和空状态处理
- 标记"使用中"的部件

## API端点

解析的6个Avatar自定义页面：
1. `/collection/avatarCustom/customiseFace/` - 面孔
2. `/collection/avatarCustom/customiseHead/` - 头部
3. `/collection/avatarCustom/customiseWear/` - 服装
4. `/collection/avatarCustom/customiseItem/` - 道具
5. `/collection/avatarCustom/customiseBack/` - 背部
6. `/collection/avatarCustom/customiseFront/` - 前部

## HTML解析逻辑

### 当前使用的部件
- 位置: `div.box01.w420` 中包含 "设置中的" 文本的块
- 提取: 图片URL、部件名称

### 可用部件列表
- 位置: `div.box01.w420[name^=wardId]`
- 提取:
  - 图片URL: `div.avatar_img_side img`
  - 名称: `div.avatar_parts_name`
  - ID: `input[name=idx]`
  - Token: `input[name=token]`

## 数据流

```
HTML页面
  ↓ (parseAvatarItems)
ChunithmAvatarItemDTO
  ↓ (转换为Entity)
ChunithmAvatarItemEntity
  ↓ (saveAvatarItems)
ObjectBox数据库
  ↓ (getAvatarItemsByCategory)
ViewModel (avatarItems)
  ↓ (collectAsState)
UI (ChunithmAvatarListPage)
```

## 使用方式

### 1. 同步数据
调用 `ChunithmRequestService.getUserData()` 会自动同步Avatar部件数据

### 2. 显示界面
```kotlin
ChunithmAvatarListPage(
    viewModel = viewModel,
    visible = isAvatarPageVisible,
    onDismiss = { isAvatarPageVisible = false }
)
```

### 3. 查询数据
```kotlin
// 在ViewModel中
viewModel.loadAvatarItems("face") // 加载面孔部件
viewModel.selectAvatarCategory("head") // 切换到头部部件

// 在ObjectBoxService中
val faceItems = objectBoxService.getAvatarItemsByCategory("face")
val currentItems = objectBoxService.getCurrentAvatarItems()
```

## 性能优化

1. **分类存储**: 按category分类存储，避免每次加载所有数据
2. **增量更新**: 使用 `saveAvatarItems(items, category)` 只替换指定类型的数据
3. **懒加载**: UI界面按需加载指定类型的部件
4. **请求限速**: 请求所有部件时每个类型间隔500ms

## 扩展性

### 添加新的部件类型
1. 在 `ChunithmAvatarItemEntity` 中添加常量
2. 在 `requestAllAvatarItems()` 的 `categories` 列表中添加
3. 在UI的 `CategoryFilterRow` 中添加对应的FilterChip

### 添加设置功能
可以在未来添加：
- 使用token向服务器发送POST请求设置Avatar部件
- 实现部件预览功能
- 支持部件收藏和搜索

## 注意事项

1. **Token有效性**: 每个部件的token可能有时效性，需要定期同步
2. **图片URL**: 图片URL是相对路径，需要拼接完整的服务器地址
3. **当前使用**: HTML中"设置中的"部件可能没有itemId，需要特殊处理
4. **请求频率**: 避免短时间内频繁请求，建议添加防抖或节流
