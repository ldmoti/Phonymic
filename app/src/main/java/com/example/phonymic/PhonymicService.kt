package com.example.phonymic // Make sure this is your actual package name

import android.accessibilityservice.AccessibilityService
import android.accessibilityservice.AccessibilityServiceInfo
import android.util.Log
import android.view.accessibility.AccessibilityEvent
import android.content.Context
import android.media.AudioManager
import android.media.AudioDeviceInfo

class PhonymicService : AccessibilityService() {

    private val TAG = "PhonymicService"

    override fun onAccessibilityEvent(event: AccessibilityEvent) {
        Log.d(TAG, "Event: $event")

        // 1. Detect Earphone Connection/Disconnection
        if (event.eventType == AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED) {
            if (isEarphoneConnected()) {
                switchAudioInputToPhone()
            }
        }
    }

    private fun isEarphoneConnected(): Boolean {
        val audioManager = getSystemService(Context.AUDIO_SERVICE) as AudioManager
        val devices = audioManager.getDevices(AudioManager.GET_DEVICES_OUTPUTS)

        for (device in devices) {
            // Check for wired headset connection
            if (device.type == AudioDeviceInfo.TYPE_WIRED_HEADSET) {
                return true
            }
        }
        return false
    }

    private fun switchAudioInputToPhone() {
        // WARNING: This is a very hacky approach and might not work reliably!

        try {
            val audioManager = getSystemService(Context.AUDIO_SERVICE) as AudioManager

            // This method is deprecated, but it might be one of the few options
            audioManager.setBluetoothScoOn(false)
            audioManager.stopBluetoothSco()
            audioManager.setMode(AudioManager.MODE_IN_CALL)
            audioManager.setSpeakerphoneOn(false)
        } catch (e: Exception) {
            Log.e(TAG, "Error switching audio input: ${e.message}")
        }
    }

    override fun onInterrupt() {
        Log.d(TAG, "Service interrupted")
    }

    override fun onServiceConnected() {
        super.onServiceConnected()
        Log.d(TAG, "Service connected")

        val info = serviceInfo
        // You can configure additional service options here if needed
        serviceInfo = info
    }
}