package com.example.permission

import android.Manifest
import android.Manifest.permission
import android.os.Build
import androidx.annotation.StringDef
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy

/**
 * Description: copy from https://github.com/Blankj/AndroidUtilCode
 * Create by dance, at 2019/4/1
 */
object PermissionConstants {
    const val CALENDAR = Manifest.permission_group.CALENDAR
    const val CAMERA = Manifest.permission_group.CAMERA
    const val CONTACTS = Manifest.permission_group.CONTACTS
    const val LOCATION = Manifest.permission_group.LOCATION
    const val MICROPHONE = Manifest.permission_group.MICROPHONE
    const val PHONE = Manifest.permission_group.PHONE
    const val SENSORS = Manifest.permission_group.SENSORS
    const val SMS = Manifest.permission_group.SMS
    const val STORAGE = Manifest.permission_group.STORAGE

    private val GROUP_CALENDAR = arrayOf(
        permission.READ_CALENDAR, permission.WRITE_CALENDAR
    )
    private val GROUP_CAMERA = arrayOf(
        permission.CAMERA
    )
    private val GROUP_CONTACTS = arrayOf(
        permission.READ_CONTACTS, permission.WRITE_CONTACTS, permission.GET_ACCOUNTS
    )
    private val GROUP_LOCATION = arrayOf(
        permission.ACCESS_FINE_LOCATION, permission.ACCESS_COARSE_LOCATION
    )
    private val GROUP_MICROPHONE = arrayOf(
        permission.RECORD_AUDIO
    )
    private val GROUP_PHONE = arrayOf(
        permission.READ_PHONE_STATE, permission.READ_PHONE_NUMBERS, permission.CALL_PHONE,
        permission.READ_CALL_LOG, permission.WRITE_CALL_LOG, permission.ADD_VOICEMAIL,
        permission.USE_SIP, permission.PROCESS_OUTGOING_CALLS, permission.ANSWER_PHONE_CALLS
    )
    private val GROUP_PHONE_BELOW_O = arrayOf(
        permission.READ_PHONE_STATE, permission.READ_PHONE_NUMBERS, permission.CALL_PHONE,
        permission.READ_CALL_LOG, permission.WRITE_CALL_LOG, permission.ADD_VOICEMAIL,
        permission.USE_SIP, permission.PROCESS_OUTGOING_CALLS
    )
    private val GROUP_SENSORS = arrayOf(
        permission.BODY_SENSORS
    )
    private val GROUP_SMS = arrayOf(
        permission.SEND_SMS, permission.RECEIVE_SMS, permission.READ_SMS,
        permission.RECEIVE_WAP_PUSH, permission.RECEIVE_MMS
    )
    private val GROUP_STORAGE = arrayOf(
        permission.READ_EXTERNAL_STORAGE, permission.WRITE_EXTERNAL_STORAGE
    )

    fun getPermissions(@Permission permission: String): Array<String> {
        when (permission) {
            CALENDAR -> return GROUP_CALENDAR
            CAMERA -> return GROUP_CAMERA
            CONTACTS -> return GROUP_CONTACTS
            LOCATION -> return GROUP_LOCATION
            MICROPHONE -> return GROUP_MICROPHONE
            PHONE -> return if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O) {
                GROUP_PHONE_BELOW_O
            } else {
                GROUP_PHONE
            }
            SENSORS -> return GROUP_SENSORS
            SMS -> return GROUP_SMS
            STORAGE -> return GROUP_STORAGE
        }
        return arrayOf(permission)
    }

    @StringDef(CALENDAR, CAMERA, CONTACTS, LOCATION, MICROPHONE, PHONE, SENSORS, SMS, STORAGE)
    @Retention(RetentionPolicy.SOURCE)
    annotation class Permission
}