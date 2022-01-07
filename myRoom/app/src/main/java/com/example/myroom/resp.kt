package com.example.myroom

import androidx.lifecycle.LiveData

class resp(private val userDao: UDao) {
        val readAllData: List<iteam> = userDao.getAll()

        suspend fun addUser(user: iteam) {
            userDao.insert(user)
        }


        suspend fun deleteUser(user: iteam) {
            userDao.delete(user.id)
        }



}