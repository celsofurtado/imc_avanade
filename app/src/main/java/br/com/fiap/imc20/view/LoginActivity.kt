package br.com.fiap.imc20.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import br.com.fiap.imc20.R
import br.com.fiap.imc20.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setListeners()

    }

    private fun setListeners() {
        binding.loginTextViewCriarConta.setOnClickListener {
            val intent = Intent(this, NovoUsuarioActivity::class.java)
            startActivity(intent)
        }

        binding.loginButtonEntrar.setOnClickListener {
            autenticar()
        }
    }

    private fun autenticar() {

        if (validar()) {
            // Abrir o arquivo
            val dados = getSharedPreferences("usuario", MODE_PRIVATE)
            val editor = dados.edit()

            val email = dados.getString("email", "")
            val senha = dados.getString("senha", "")

            if (binding.loginCheckBoxLembrar.isChecked) {
                editor.putBoolean("lembrar", true)
            } else {
                editor.putBoolean("lembrar", false)
            }

            editor.commit()

            if (email == binding.loginEditTextEmail.text.toString() && senha == binding.loginEditTextPassword.text.toString()){
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Usuário ou senha incorretos!", Toast.LENGTH_SHORT).show()
            }
        }


    }

    private fun validar(): Boolean {

        if (binding.loginEditTextEmail.text.isEmpty()) {
            binding.loginEditTextEmail.error = "E-mail é obrigatório!"
            return false
        }

        if (binding.loginEditTextPassword.text.isEmpty()){
            binding.loginEditTextPassword.error = "Senha é obrigatório!"
            return false
        }

        return true

    }
}