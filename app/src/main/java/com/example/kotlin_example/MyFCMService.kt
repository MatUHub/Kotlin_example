package com.example.kotlin_example

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

//Server Key
//AAAAQn9EONM:APA91bEjn9xo1Hjgly3vqe8Bsst3QNNe1ZgcSiCxOA_P9MULPXMo6NdvTv9dtVLzdI2ae3HzAxKkmsNbK0fRyJRh7M0o4MpMy1oYyRx5OB5TVyGCy1DvWxJwBj9-HwfHFnF2I1HQsJ7i

class MyFCMService : FirebaseMessagingService() {
    //для индентификации пользователя которому отпрвлено сообщение создается Token
    override fun onNewToken(s: String) {
        super.onNewToken(s)
    }

//получаем с сервера сообщение
    override fun onMessageReceived(message: RemoteMessage) {
        val data = message.data
        if(data.isNotEmpty()){
            val title = data[KEY_TITLE]
            val message = data[KEY_MESSAGE]

            if(!title.isNullOrBlank()&&!message.isNullOrBlank())
                //выводим в уведомлении сообщение
                pushNotification(title, message)
        }
    }


    companion object {

        private const val KEY_TITLE = "myTitle"
        private const val KEY_MESSAGE = "myMessage"

        // уникальные индефикаторы уведомлений

        private const val NOTIFICATION_ID_1 = 1
        /*private const val NOTIFICATION_ID_2 = 2*/

        private const val CHANNEL_ID_1 = "channel_id_1"
        /* private const val CHANNEL_ID_2 = "channel_id_2"*/
    }

    //функция вызова уведомления
    private fun pushNotification(title: String, message: String) {
        //получение менеджера уведомлений
        val notificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
//создание уведомления
        val notificationBuilderOne = NotificationCompat.Builder(this, CHANNEL_ID_1).apply {
            setSmallIcon(R.drawable.ic_kotlin_logo)
            setContentTitle(title)
            setContentText(message)
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

        //создание уведомления
        /*val notificationBuilderTwo = NotificationCompat.Builder(this, CHANNEL_ID_2).apply {
            setSmallIcon(R.drawable.ic_kotlin_logo)
            setContentTitle("Заголовок (канал 1) $CHANNEL_ID_2")
            setContentText("Сообщение (канал 1) $CHANNEL_ID_2")
            //задание приоритета уведомления
            priority = NotificationCompat.PRIORITY_MAX
        }*/

        //передача уведомления в NotificationManager, создание уведомления на устройстве


        /* //Build.VERSION_CODES.O получение версии андройда (О -> Oreo)
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
    }*/
    }

    // добавить в Manifest

    /*<service //
          android:name="MyFCMService"
          android:exported="true">

          //по данному интент фильтру происходит получение данных через Firebase

        <intent-filter>
           <action android:name="com.google.firebase.MESSAGING_EVENT" />
       </intent-filter>
    </service>*/
}