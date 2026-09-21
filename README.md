咖啡点单应用
基于 Jetpack Compose 声明式 UI 搭建全部页面，使用 Scaffold、LazyVerticalGrid、NavigationBar 等组件完成商品网格、顶栏、底部导航等界面，自定义主题配色与组件样式。
采用 单 Activity + Compose Navigation 架构，使用 kotlinx.serialization 的类型安全路由（含参数传递）实现欢迎页、首页、详情页、购物车、收藏夹、个人中心之间的导航。
使用SnapshotStateList /SnapshotStateMap 实现全局 购物车与收藏夹的响应式状态管理 ，数据变化时多页面自动重组，支持商品数量增减、价格实时汇总、收藏状态跨页面同步。
实现首页 分类筛选 （全部/咖啡/拿铁/其他）与商品名称联动过滤；收藏按钮支持描边/实心心形双状态切换。
封装底部导航栏组件，配合popUpTo + saveState/restoreState + launchSingleTop 实现 Tab 状态保存恢复与实例复用 ，避免重复点击当前 Tab 创建新实例。
处理导航栈生命周期：欢迎页首次启动后清栈、非首页按返回键直接回首页、首页双击返回退出应用（Toast 提示），优化返回栈体验。
