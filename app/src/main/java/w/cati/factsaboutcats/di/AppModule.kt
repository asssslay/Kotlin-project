package w.cati.factsaboutcats.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import w.cati.factsaboutcats.data.local.FactsDatabase
import w.cati.factsaboutcats.data.local.repository.FactsRepositoryDBImpl
import w.cati.factsaboutcats.data.remote.FactsApi
import w.cati.factsaboutcats.data.repository.FactRepositoryImpl
import w.cati.factsaboutcats.domain.repository.FactRepository
import w.cati.factsaboutcats.domain.repository.FactsRepositoryDB
import w.cati.factsaboutcats.domain.use_case.FactUseCases
import w.cati.factsaboutcats.domain.use_case.get_facts_local.GetFactsFromDBUseCase
import w.cati.factsaboutcats.domain.use_case.get_facts_remote.GetFactsUseCase
import w.cati.factsaboutcats.domain.use_case.insert_fact_local.InsertFactUseCase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideFactsDatabase(app: Application): FactsDatabase {
        return Room.databaseBuilder(
            app,
            FactsDatabase::class.java,
            FactsDatabase.DATABASE_NAME
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideFactsRepositoryDB(db: FactsDatabase): FactsRepositoryDB {
        return FactsRepositoryDBImpl(db.factDao)
    }


    @Provides
    @Singleton
    fun provideFactsApi(): FactsApi {
        return Retrofit.Builder()
            .baseUrl("https://catfact.ninja/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(FactsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideFactRepository(api: FactsApi): FactRepository {
        return FactRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideFactUseCases(
        repository: FactRepository,
        repositoryDB: FactsRepositoryDB
    ): FactUseCases {
        return FactUseCases(
            getCoinUseCase = GetFactsUseCase(repository),
            insertFactUseCase = InsertFactUseCase(repositoryDB),
            getFactsFromDBUseCase = GetFactsFromDBUseCase(repositoryDB)
        )
    }

}