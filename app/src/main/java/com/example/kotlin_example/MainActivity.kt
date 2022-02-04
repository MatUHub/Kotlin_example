package com.example.kotlin_example

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat

class MainActivity : AppCompatActivity() {


    companion object {

        // уникальные индефикаторы уведомлений

        private const val NOTIFICATION_ID_1 = 1
        private const val NOTIFICATION_ID_2 = 2

        private const val CHANNEL_ID_1 = "channel_id_1"
        private const val CHANNEL_ID_2 = "channel_id_2"
    }

    //функция вызова уведомления
    private fun pushNotification() {
        //получение менеджера уведомлений
        val notificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
//создание уведомления
        val notificationBuilderOne = NotificationCompat.Builder(this, CHANNEL_ID_1).apply {
            setSmallIcon(R.drawable.ic_kotlin_logo)
            setContentTitle("Заголовок (канал 1) $CHANNEL_ID_1")
            setContentText("Сообщение (канал 1) $CHANNEL_ID_1")
            //задание приоритета уведомления
            priority = NotificationCompat.PRIORITY_MAX
        }
//создание уведомления
        val notificationBuilderTwo = NotificationCompat.Builder(this, CHANNEL_ID_2).apply {
            setSmallIcon(R.drawable.ic_kotlin_logo)
            setContentTitle("Заголовок (канал 1) $CHANNEL_ID_2")
            setContentText("Сообщение (канал 1) $CHANNEL_ID_2")
            //задание приоритета уведомления
            priority = NotificationCompat.PRIORITY_MAX
        }

//Build.VERSION_CODES.O получение версии андройда (О -> Oreo)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            //создание полей для канала
            val channelNameOne = "Name $CHANNEL_ID_1"
            val channelDescriptionOne = "Description $CHANNEL_ID_1"
            val channelPriorityOne = NotificationManager.IMPORTANCE_HIGH

            //создание канала
            val channelOne = NotificationChannel(CHANNEL_ID_1, channelNameOne, channelPriorityOne)
            channelOne.description = channelDescriptionOne

//передача канала в NotificationManager, создание канала на устройстве
            notificationManager.createNotificationChannel(channelOne)
        }

        //передача уведомления в NotificationManager, создание уведомления на устройстве
        notificationManager.notify(NOTIFICATION_ID_1, notificationBuilderOne.build())

        //Build.VERSION_CODES.O получение версии андройда (О -> Oreo)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            //создание полей для канала
            val channelNameTwo = "Name $CHANNEL_ID_2"
            val channelDescriptionTwo = "Description $CHANNEL_ID_2"
            val channelPriorityTwo = NotificationManager.IMPORTANCE_HIGH

            //создание канала
            val channelTwo = NotificationChannel(CHANNEL_ID_2, channelNameTwo, channelPriorityTwo)
            channelTwo.description = channelDescriptionTwo

//передача канала в NotificationManager, создание канала на устройстве
            notificationManager.createNotificationChannel(channelTwo)
        }
        //передача уведомления в NotificationManager, создание уведомления на устройстве
        notificationManager.notify(NOTIFICATION_ID_2, notificationBuilderTwo.build())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        pushNotification()
    }
}