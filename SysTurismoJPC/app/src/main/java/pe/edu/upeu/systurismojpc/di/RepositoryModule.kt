package pe.edu.upeu.systurismojpc.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import pe.edu.upeu.systurismojpc.repository.UsuarioRepository
import pe.edu.upeu.systurismojpc.repository.UsuarioRepositoryImp
import javax.inject.Singleton


/*@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun userRepository(userRepos: UsuarioRepositoryImp): UsuarioRepositoryImp
}*/

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindUsuarioRepository(userRepos: UsuarioRepositoryImp?): UsuarioRepository?
}
