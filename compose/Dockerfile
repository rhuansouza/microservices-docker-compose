# Use a imagem oficial do MySQL como imagem base
FROM mysql:latest

# Defina variáveis de ambiente para o nome de usuário e senha do MySQL
ENV MYSQL_ROOT_PASSWORD=123456
ENV MYSQL_USER=rhuan
ENV MYSQL_PASSWORD=123456

# Opcionalmente, defina o nome do banco de dados padrão
ENV MYSQL_DATABASE=cadastro


#COPY my.cnf /etc/mysql/conf.d/my.cnf

# Você pode personalizar outras configurações aqui, se necessário

# Exponha a porta padrão do MySQL
EXPOSE 3306