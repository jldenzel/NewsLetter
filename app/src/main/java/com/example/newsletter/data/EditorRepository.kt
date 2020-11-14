package com.example.newsletter.data

import com.example.newsletter.data.service.EditeurOnlineService
import com.example.newsletter.models.EditeurResponse

class EditorRepository {
    private val apiService: EditeurOnlineService

    init {
        apiService = EditeurOnlineService()
    }

    fun getEditeur(): EditeurResponse = apiService.getEditeur()


    companion object {
        private var instance: EditorRepository? = null
        fun getInstance(): EditorRepository {
            if (instance == null) {
                instance = EditorRepository()
            }
            return instance!!
        }
    }
}