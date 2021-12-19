package com.e.domain.usecase.appInfoUseCase

import com.e.domain.repository.AppInfoRepo
import javax.inject.Inject

class GetCategoryUseCase @Inject constructor(private val appInfoRepo: AppInfoRepo) {

    suspend fun execute() = appInfoRepo.getCategory()

}