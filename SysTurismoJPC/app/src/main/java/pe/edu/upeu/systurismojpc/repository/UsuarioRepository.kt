package pe.edu.upeu.systurismojpc.repository

import pe.edu.upeu.systurismojpc.data.remote.RestUsuario
import pe.edu.upeu.systurismojpc.modelo.UsuarioDto
import pe.edu.upeu.systurismojpc.modelo.UsuarioResp
import retrofit2.Response
import javax.inject.Inject

interface UsuarioRepository {
    suspend fun loginUsuario(user: UsuarioDto):
            Response<UsuarioResp>
}
class UsuarioRepositoryImp @Inject constructor(private val restUsuario: RestUsuario):UsuarioRepository{
    override suspend fun loginUsuario(user:UsuarioDto):
            Response<UsuarioResp>{
        return restUsuario.login(user)
    }
}
