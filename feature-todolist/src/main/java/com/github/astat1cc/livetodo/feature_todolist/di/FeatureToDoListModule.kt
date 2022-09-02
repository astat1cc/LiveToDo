package com.github.astat1cc.livetodo.feature_todolist.di

import com.github.astat1cc.livetodo.feature_todolist.data.ToDoListRepositoryImpl
import com.github.astat1cc.livetodo.feature_todolist.data.network.ToDoListNetworkDataSource
import com.github.astat1cc.livetodo.feature_todolist.data.network.api.ToDoListService
import com.github.astat1cc.livetodo.feature_todolist.data.network.mappers.ToDoDTOtoDomainMapper
import com.github.astat1cc.livetodo.feature_todolist.domain.ToDoListInteractor
import com.github.astat1cc.livetodo.feature_todolist.domain.ToDoListRepository
import com.github.astat1cc.livetodo.feature_todolist.ui.ToDoListViewModel
import com.github.astat1cc.livetodo.feature_todolist.ui.mappers.ToDoDomainToUiMapper
import com.github.astat1cc.livetodo.feature_todolist.ui.mappers.ToDoListResponseDomainToUiMapper
import com.github.astat1cc.livetodo.feature_todolist.ui.mappers.ToDoListResponseUiToScreenItemsMapper
import com.github.astat1cc.livetodo.feature_todolist.ui.mappers.ToDoUiToScreenItemMapper
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
        ToDoDomainToUiMapper.Impl()
    }
    factory<ToDoListResponseDomainToUiMapper> {
        ToDoListResponseDomainToUiMapper.Impl(mapper = get(), resourceProvider = get())
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
