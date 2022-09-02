package com.github.astat1cc.livetodo.core.abstracts

abstract class Abstract {

    // object that can be mapped to type R by mapper of type M
    interface Object<R, M : Mapper<R>> {

        fun map(mapper: M): R
    }

    // mapper that maps object A to object B of type T using object A fields
    interface Mapper<T>
}