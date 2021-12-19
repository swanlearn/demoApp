package com.e.data.mapper

import com.e.data.entity.Service
import com.e.domain.models.ServiceModel
import javax.inject.Inject

class ServiceMapper @Inject constructor(){
    fun toMapper(agents: Service): ServiceModel {
        return ServiceModel(
            agents.id ?: 0,
            agents.addType ?: "",
            agents.agentprice ?: "",
            agents.apiProviderId ?: "",
            agents.apiServiceId ?: "",
            agents.cateId ?: "",
            agents.changed ?: "",
            agents.created ?: "",
            agents.desc ?: "",
            agents.dripfeed ?: "",
            agents.ids ?: "",
            agents.max ?: "",
            agents.min ?: "",
            agents.name ?: "",
            agents.oagentprice ?: "",
            agents.originalPrice ?: "",
            agents.price ?: "",
            agents.product_type ?: "",
            agents.sortService ?: "",
            agents.status ?: "",
            agents.type ?: "",
            agents.uid ?: ""
        )
    }

}