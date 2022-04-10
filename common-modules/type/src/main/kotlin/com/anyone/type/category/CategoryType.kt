package com.anyone.type.category

import com.anyone.type.EnumType

enum class CategoryType(
    private val description: String
): EnumType {
    HEALTH("헬스"),
    TENNIS("테니스"),
    SOCCER("축구"),
    PILATES("피라테스"),
    CROSS_FIT("크로스핏"),
    BASKETBALL("농구");

    override fun getDescription(): String {
        return this.description;
    }

    override fun getCode(): String {
        return this.name
    }}