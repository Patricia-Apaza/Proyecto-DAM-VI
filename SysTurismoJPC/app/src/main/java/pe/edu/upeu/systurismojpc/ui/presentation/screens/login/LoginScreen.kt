package pe.edu.upeu.systurismojpc.ui.presentation.screens.login

import android.os.Build
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.github.k0shk0sh.compose.easyforms.BuildEasyForms
import com.github.k0shk0sh.compose.easyforms.EasyFormsResult
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import pe.edu.upeu.systurismojpc.ui.presentation.components.ErrorImageAuth
import pe.edu.upeu.systurismojpc.ui.presentation.components.ImageLogin
import pe.edu.upeu.systurismojpc.ui.presentation.components.ProgressBarLoading
import pe.edu.upeu.systurismojpc.ui.presentation.components.form.EmailTextField
import pe.edu.upeu.systurismojpc.ui.presentation.components.form.LoginButton
import pe.edu.upeu.systurismojpc.ui.presentation.components.form.PasswordTextField
import pe.edu.upeu.systurismojpc.ui.theme.LightRedColors
import pe.edu.upeu.systurismojpc.ui.theme.SysTurismoJPCTheme
import pe.edu.upeu.systurismojpc.utils.ComposeReal

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun LoginScreen(
    navigateToHome: () -> Unit,
    viewModel: LoginViewModel = hiltViewModel()
) {
    val isLoading by viewModel.isLoading.observeAsState(false)
    val isLogin by viewModel.isLogin.observeAsState(false)
    val isError by viewModel.isError.observeAsState(false)
    val loginResult by viewModel.loginResponse.observeAsState()
    val errorMessage by viewModel.errorMessage.observeAsState()

    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    val context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ImageLogin()
        Text("Login Screen", fontSize = 40.sp)

        BuildEasyForms { easyForm ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                EmailTextField(easyForms = easyForm, text = "", "E-Mail:", "U")
                PasswordTextField(easyForms = easyForm, text = "", label = "Password:")

                LoginButton(easyForms = easyForm, onClick = {
                    val dataForm = easyForm.formData()
                    val correo = (dataForm.get(0) as EasyFormsResult.StringResult).value
                    val contraseña = (dataForm.get(1) as EasyFormsResult.StringResult).value

                    viewModel.loginSys(correo, contraseña)

                    scope.launch {
                        delay(2000L) // Esperar respuesta del backend
                        if (viewModel.isLogin.value == true && loginResult != null) {
                            Log.i("LOGIN_SUCCESS", "Bienvenido ${loginResult!!.correo}")
                            navigateToHome.invoke()
                        } else {
                            Log.v("LOGIN_ERROR", "Error logeo")
                            Toast.makeText(context, "Error al iniciar sesión", Toast.LENGTH_LONG).show()
                        }
                    }
                },
                    label = "Log In"
                )

                ComposeReal.COMPOSE_TOP.invoke()
            }
        }

        ErrorImageAuth(isImageValidate = isError)
        ProgressBarLoading(isLoading = isLoading)
    }

    // Mostrar Snackbar manualmente si hay error
    SnackbarHost(
        hostState = snackbarHostState,
        modifier = Modifier
            .wrapContentHeight(Alignment.Bottom)
            .padding(16.dp),
    )

    LaunchedEffect(errorMessage) {
        errorMessage?.let {
            snackbarHostState.showSnackbar(it)
            viewModel.clearErrorMessage()
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    val colors = LightRedColors
    val darkTheme = isSystemInDarkTheme()
    SysTurismoJPCTheme(colorScheme = colors) {
        LoginScreen(
            navigateToHome = {}
        )
    }
}
