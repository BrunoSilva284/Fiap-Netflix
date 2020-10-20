--   docker run --name netflix-database -e "POSTGRES_PASSWORD=123456"  -e "POSTGRES_DB=netflix-suporte" -p 5432:5432 -d postgres
--
--   docker run -d --hostname my-rabbit --name rabbit13 -p 15672:15672 -p 5672:5672 -p 25676:25676 rabbitmq:3-management
--
--   docker exec -it netflix-database bash
--
--   psql -U postgres
--   \c netflix-suporte



--COLOCAR FILA PARA PERSISTIR SINCRONO
INSERT INTO ticket ( data_criacao, desc_erro, id_filme, id_usuario, atendente_id_atendente) VALUES ( '2020-10-19 22:59:41.373000', 'Ta sem legenda no filme!', 7, 999, null);
INSERT INTO ticket ( data_criacao, desc_erro, id_filme, id_usuario, atendente_id_atendente) VALUES ( '2020-10-19 23:00:02.438000', 'Não sei minha senha', 0, 654, null);
INSERT INTO ticket ( data_criacao, desc_erro, id_filme, id_usuario, atendente_id_atendente) VALUES ( '2020-10-19 23:00:18.246000', 'Quando clico no play trava o vídeo!', 1, 44, null);
INSERT INTO ticket ( data_criacao, desc_erro, id_filme, id_usuario, atendente_id_atendente) VALUES ( '2020-10-19 23:00:36.926000', 'Quando clico no play só fica carregando a tela!', 8, 888, null);
INSERT INTO ticket ( data_criacao, desc_erro, id_filme, id_usuario, atendente_id_atendente) VALUES ( '2020-10-19 23:01:02.972000', 'Tela ta com cores estranhas!', 2, 28, null);