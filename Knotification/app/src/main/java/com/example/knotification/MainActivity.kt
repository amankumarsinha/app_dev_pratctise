package com.example.knotification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.TaskStackBuilder
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val channel_ID= "channelid"
    val channel_NAME = "channelname"
    val Notification_ID =0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        createNotificationchannel()

        val intent = Intent(this,MainActivity::class.java)
        val pendigIntent = TaskStackBuilder.create(this).run {
            addNextIntentWithParentStack(intent)
            getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT)
        }

        val notification = NotificationCompat.Builder(this,channel_ID)
            .setContentTitle("maan notification")
            .setContentText("here there where")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(pendigIntent)
            .build()
        val notificationManager = NotificationManagerCompat.from(this)
        button.setOnClickListener {
            notificationManager.notify(Notification_ID , notification)
        }

    }
    fun createNotificationchannel()
    {
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.O)
        {
            val channel = NotificationChannel(channel_ID,channel_NAME,NotificationManager.IMPORTANCE_DEFAULT).apply {
                lightColor =Color.RED
                enableLights(true)

            }
            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(channel)
        }
    }
}