package com.github.astat1cc.livetodo.feature_todolist.di

import com.github.astat1cc.livetodo.core.ResourceProvider
import com.github.astat1cc.livetodo.feature_todolist.data.ToDoListRepositoryImpl
import com.github.astat1cc.livetodo.feature_todolist.data.network.ToDoListNetworkDataSource
import com.github.astat1cc.livetodo.feature_todolist.data.network.api.ToDoListService
import com.github.astat1cc.livetodo.feature_todolist.data.network.entities.ToDoDTOtoDomainMapper
import com.github.astat1cc.livetodo.feature_todolist.domain.ToDoListInteractor
import com.github.astat1cc.livetodo.feature_todolist.domain.ToDoListRepository
import com.github.astat1cc.livetodo.feature_todolist.domain.mappers.ToDoDomainToUiMapper
import com.github.astat1cc.livetodo.feature_todolist.domain.mappers.ToDoListResponseDomainToUiMapper
import com.github.astat1cc.livetodo.feature_todolist.ui.ToDoListViewModel
import com.github.astat1cc.livetodo.feature_todolist.ui.mappers.ToDoDomainToUiMapperImpl
import com.github.astat1cc.livetodo.feature_todolist.ui.mappers.ToDoListResponseDomainToUiMapperImpl
import com.github.astat1cc.livetodo.feature_todolist.ui.mappers.ToDoListResponseUiToScreenItemsMapper
import com.github.astat1cc.livetodo.feature_todolist.ui.mappers.ToDoUiToScreenItemMapper
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val featureToDoListModule = module {
    single {
        provideToDoListService(retrofit = get())
    }
    single<ToDoListNetworkDataSource> {
        ToDoListNetworkDataSource.Impl(service = get())
    }
    factory<ToDoDTOtoDomainMapper> {
        ToDoDTOtoDomainMapper.Impl()
    }
    single<ToDoListRepository> {
        ToDoListRepositoryImpl(networkDataSource = get(), networkMapper = get())
    }
    factory<ToDoListInteractor> {
        ToDoListInteractor.Impl(repository = get(), exceptionHandler = get())
    }
    factory<ToDoDomainToUiMapper> {
        ToDoDomainToUiMapperImpl()
    }
    factory<ToDoListResponseDomainToUiMapper> {
        ToDoListResponseDomainToUiMapperImpl(mapper = get(), resourceProvider = get())
    }
    factory<ToDoUiToScreenItemMapper> {
        ToDoUiToScreenItemMapper.Impl()
    }
    factory<ToDoListResponseUiToScreenItemsMapper> {
        ToDoListResponseUiToScreenItemsMapper.Impl(mapper = get())
    }
    viewModel {
        ToDoListViewModel(
            interactor = get(),
            domainToUiMapper = get(),
            responseToScreenItemMapper = get(),
            resourceProvider = get()
        )
    }
}

private fun provideToDoListService(retrofit: Retrofit): ToDoListService =
    retrofit.create(ToDoListService::class.java)
