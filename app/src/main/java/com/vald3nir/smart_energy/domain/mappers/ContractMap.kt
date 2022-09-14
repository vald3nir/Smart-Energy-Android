package com.vald3nir.smart_energy.domain.mappers

import com.vald3nir.smart_energy.data.database.entities.ContractEntity
import com.vald3nir.smart_energy.data.dtos.ContractDTO


fun ContractEntity?.asDTO(): ContractDTO? {
    return if (this != null) {
        ContractDTO(
            alias = alias,
            clientId = clientId,
            createdAt = createdAt,
            items = items,
        )
    } else null
}

fun ContractDTO?.asEntity(): ContractEntity? {
    return if (this != null) {
        ContractEntity(
            alias = alias,
            clientId = clientId,
            createdAt = createdAt,
            items = items,
        )
    } else null
}