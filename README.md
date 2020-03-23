# Compassito

Card - Autenticação de Usuário via Token e Consulta Saldo Usuário 

Login(POST): http://localhost:8080/login
"email": "fulano@compasso.com.br", "senha":"123"
Reposta:
"token": "token gerado referente a senha usuario"
"tipo": "Bearer"
"id_usuario": número id_usuário

=========================================================================================

Saldo(GET): http://localhost:8080/saldo/id_usuario
Headers:
Key : Authorization, Value: Bearer token
Resposta:
"saldo": saldo referente id_usuario
