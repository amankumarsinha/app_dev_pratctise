package com.example.kintentservice

import android.content.Intent
import android.app.IntentService
import android.util.Log

class MyIntentService : IntentService("aman") {
   companion object {
       private lateinit var instance : MyIntentService
       var isRunning =false

       fun stopService(){
           Log.d("aman","sevice is stopping")
           isRunning=false
           instance.stopSelf()
       }
   }


    override fun onHandleIntent(p0: Intent?) {
       try {
           isRunning= true
           while(isRunning)
           {
               Log.d("mana","service is running")
               Thread.sleep(1000)
           }
       }
       catch (e: InterruptedException)
       {
           Thread.currentThread().interrupt()
       }
    }


}