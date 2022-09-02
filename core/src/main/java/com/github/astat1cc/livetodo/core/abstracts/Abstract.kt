package com.github.astat1cc.livetodo.core.abstracts

abstract class Abstract {

    /**
     *  Mapper that maps object A of type S to object B of type R
     */
    interface ObjectMapper<in S, out R> {

        fun mapFrom(source: S): R
    }
}