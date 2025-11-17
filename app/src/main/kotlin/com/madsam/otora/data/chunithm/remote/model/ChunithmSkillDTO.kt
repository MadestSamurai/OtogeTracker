package com.madsam.otora.data.chunithm.remote.model

/**
 * Chunithm 技能数据
 */
internal data class ChunithmSkillDTO(
    val currentSkill: SkillInfo? = null,          // 当前使用的技能
    val skillList: List<SkillInfo> = emptyList()  // 所有技能列表
)

/**
 * 技能信息
 */
internal data class SkillInfo(
    val idx: String = "",                         // 技能ID
    val iconUrl: String = "",                     // 技能图标URL
    val versionIconUrl: String = "",              // 版本图标URL（可选）
    val name: String = "",                        // 技能名称
    val level: Int = 0,                           // 技能等级
    val description: String = "",                 // 技能描述
    val token: String = "",                       // 表单token
    val isCurrentlyUsed: Boolean = false          // 是否正在使用
)
