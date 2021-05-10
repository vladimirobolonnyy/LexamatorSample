package com.obolonnyy.lexemator.domain

import com.obolonnyy.lexemator.LL
import com.obolonnyy.lexemator.repository.LexemRepository
import com.obolonnyy.lexemator.repository.LexemRepositoryImpl


class UpdateStringsInteractor(
    private val lexemRepository: LexemRepository = LexemRepositoryImpl()
) {

    suspend fun invoke() {
        val result = runCatching { lexemRepository.getLatestStrings() }.getOrNull()
        if (result != null) {
            LL.addLexems(result)
        }
    }
}