package com.madsam.otora.data.maimai.remote.api

import android.content.Context
import android.util.Log
import com.fleeksoft.ksoup.Ksoup
import kotlinx.coroutines.runBlocking
import java.io.File

/**
 * Maimai 数据解析测试工具
 * 用于测试从 HTML 文件中解析数据
 */
class MaimaiParserTest(private val context: Context) {
    companion object {
        private const val TAG = "MaimaiParserTest"
    }
    
    /**
     * 测试解析本地 HTML 文件
     * @param htmlFilePath HTML 文件的绝对路径
     */
    fun testParseFromFile(htmlFilePath: String) {
        try {
            Log.d(TAG, "Reading HTML file: $htmlFilePath")
            val htmlContent = File(htmlFilePath).readText()
            val doc = Ksoup.parse(htmlContent)
            
            // 创建临时的 RequestService 实例用于访问解析方法
            val requestService = MaimaiRequestService(context)
            
            // 使用反射调用私有方法进行测试
            val parseMaimaiScoresMethod = MaimaiRequestService::class.java
                .getDeclaredMethod("parseMaimaiScores", com.fleeksoft.ksoup.nodes.Document::class.java)
            parseMaimaiScoresMethod.isAccessible = true
            
            val scores = parseMaimaiScoresMethod.invoke(requestService, doc) as List<*>
            
            Log.d(TAG, "====================================")
            Log.d(TAG, "解析结果汇总：")
            Log.d(TAG, "总共解析了 ${scores.size} 首乐曲")
            Log.d(TAG, "====================================")
            
            scores.forEachIndexed { index, score ->
                score as com.madsam.otora.data.maimai.remote.model.MaimaiScoreDTO
                Log.d(TAG, "")
                Log.d(TAG, "乐曲 ${index + 1}:")
                Log.d(TAG, "  标题: ${score.title}")
                Log.d(TAG, "  难度: ${score.difficulty} ${score.level}")
                Log.d(TAG, "  类型: ${score.genre}")
                if (score.score.isNotEmpty()) {
                    Log.d(TAG, "  得分: ${score.score}%")
                }
                if (score.deluxscore.isNotEmpty()) {
                    Log.d(TAG, "  DX分数: ${score.deluxscore}")
                }
                if (score.rank.isNotEmpty()) {
                    Log.d(TAG, "  评级: ${score.rank}")
                }
                if (score.comboStatus.isNotEmpty()) {
                    Log.d(TAG, "  Combo: ${score.comboStatus}")
                }
                if (score.syncStatus.isNotEmpty()) {
                    Log.d(TAG, "  Sync: ${score.syncStatus}")
                }
                if (score.id.isNotEmpty()) {
                    Log.d(TAG, "  ID: ${score.id.take(50)}...")
                }
            }
            
            // 测试统计数据解析
            Log.d(TAG, "")
            Log.d(TAG, "====================================")
            Log.d(TAG, "测试统计数据解析")
            Log.d(TAG, "====================================")
            
            val parsePlayRecordMethod = MaimaiRequestService::class.java
                .getDeclaredMethod("parsePlayRecord", com.fleeksoft.ksoup.nodes.Document::class.java)
            parsePlayRecordMethod.isAccessible = true
            
            val records = parsePlayRecordMethod.invoke(requestService, doc) as List<*>
            records.forEach { record ->
                record as com.madsam.otora.data.maimai.remote.model.MaimaiPlayRecordDTO
                Log.d(TAG, "难度: ${record.difficulty}")
                Log.d(TAG, "  Clear: ${record.clearCount}/${record.clearTotal}")
                Log.d(TAG, "  FC: ${record.fcCount}/${record.fcTotal}, FC+: ${record.fcpCount}/${record.fcpTotal}")
                Log.d(TAG, "  AP: ${record.apCount}/${record.apTotal}, AP+: ${record.appCount}/${record.appTotal}")
                Log.d(TAG, "  FS: ${record.fsCount}/${record.fsTotal}, FS+: ${record.fspCount}/${record.fspTotal}")
                Log.d(TAG, "  FDX: ${record.fdxCount}/${record.fdxTotal}, FDX+: ${record.fdxpCount}/${record.fdxpTotal}")
            }
            
            Log.d(TAG, "")
            Log.d(TAG, "====================================")
            Log.d(TAG, "测试完成！")
            Log.d(TAG, "====================================")
            
        } catch (e: Exception) {
            Log.e(TAG, "测试失败", e)
        }
    }
}

/**
 * 使用示例：
 * 
 * // 在 Activity 或 ViewModel 中调用
 * val tester = MaimaiParserTest(context)
 * val htmlPath = "C:\\Users\\18913\\Documents\\GitHub\\OtogeTracker\\maimai\\record\\musicGenre\\search.html"
 * 
 * // 在协程中执行
 * lifecycleScope.launch {
 *     tester.testParseFromFile(htmlPath)
 * }
 */
