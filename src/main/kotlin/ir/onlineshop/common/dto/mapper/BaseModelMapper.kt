package ir.onlineshop.common.dto.mapper

import org.modelmapper.ModelMapper

open class BaseModelMapper{
    private val modelMapper = ModelMapper()

    fun <M,D> toDto(model: M, dClass: Class<D>): D {
        return modelMapper.map(model, dClass)
    }

    fun <M,D> toDtoList(modelList: List<M>, dClass: Class<D>): List<D> {
        return modelList.asSequence()
            .map { modelMapper.map(it, dClass) }
            .toList()
    }

    fun <M,D> toModel(dto: D, mClass: Class<M>): M {
        return modelMapper.map(dto, mClass)
    }

    fun <M,D> toListOfModel(dtoList: List<D>, mClass: Class<M>): List<M> {
        return dtoList.asSequence()
            .map { modelMapper.map(it, mClass) }
            .toList()
    }
}