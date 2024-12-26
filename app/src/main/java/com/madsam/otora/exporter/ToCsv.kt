package com.madsam.otora.exporter

import com.madsam.otora.entity.ChuniSheetsEntity
import com.madsam.otora.entity.ChuniSongsEntity
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import java.io.FileWriter
import java.io.IOException

/**
 * 项目名: OtogeTracker
 * 文件名: com.madsam.otora.exporter.ToCsv
 * 创建者: MadSamurai
 * 创建时间: 2024/12/26
 * 描述: 导出Chunithm歌曲数据到CSV
 */

fun exportChuniSongsToCSV(realmConfig: RealmConfiguration, filePath: String, fileNameSongs: String, fileNameSheets: String) {
    val realm = Realm.open(realmConfig)
    val chuniSongs = realm.query<ChuniSongsEntity>(clazz = ChuniSongsEntity::class).find()
    val chuniSheets = realm.query<ChuniSheetsEntity>(clazz = ChuniSheetsEntity::class).find()

    fun escapeCsvField(field: String): String {
        return if (field.contains(",") || field.contains("\"")) {
            "\"${field.replace("\"", "\"\"")}\""
        } else {
            field
        }
    }

    try {
        FileWriter(filePath + fileNameSongs).use { writer ->
            // Write ChuniSongsEntity header
            writer.write("id,genre,title,artist,bpm,imageName,version,releaseDate,isNew,isLocked,comment,cnId,map,aliases\n")

            // Write ChuniSongsEntity data
            for (song in chuniSongs) {
                writer.write("${escapeCsvField(song.id)},${escapeCsvField(song.genre)},${escapeCsvField(song.title)},${escapeCsvField(song.artist)},${song.bpm},${escapeCsvField(song.imageName)},${escapeCsvField(song.version)},${escapeCsvField(song.releaseDate)},${song.isNew},${song.isLocked},${escapeCsvField(song.comment)},${song.cnId},${escapeCsvField(song.map)},${escapeCsvField(song.aliases)}\n")
            }
        }
        FileWriter(filePath + fileNameSheets).use { writer ->
            // Write ChuniSheetsEntity header
            writer.write("id,type,difficulty,levelJp,levelValueJp,internalLevelJp,internalLevelValueJp,levelCn,levelValueCn,noteDesigner,tap,hold,slide,air,flick,total,jp,intl,cn,isSpecial,version,originId,kanji,star\n")

            // Write ChuniSheetsEntity data
            for (sheet in chuniSheets) {
                writer.write("${escapeCsvField(sheet.id)},${escapeCsvField(sheet.type)},${escapeCsvField(sheet.difficulty)},${escapeCsvField(sheet.levelJp)},${sheet.levelValueJp},${escapeCsvField(sheet.internalLevelJp)},${sheet.internalLevelValueJp},${escapeCsvField(sheet.levelCn)},${sheet.levelValueCn},${escapeCsvField(sheet.noteDesigner)},${sheet.tap},${sheet.hold},${sheet.slide},${sheet.air},${sheet.flick},${sheet.total},${sheet.jp},${sheet.intl},${sheet.cn},${sheet.isSpecial},${sheet.version},${sheet.originId},${escapeCsvField(sheet.kanji)},${sheet.star}\n")
            }
        }
    } catch (e: IOException) {
        e.printStackTrace()
    } finally {
        realm.close()
    }
}