-- Crear los usuarios
CREATE USER user_view WITH PASSWORD 'password1';
CREATE USER user_service WITH PASSWORD 'password2';

-- Otorgar todos los privilegios en la base de datos
GRANT ALL PRIVILEGES ON DATABASE postgres_reactive_ddd TO user_view;
GRANT ALL PRIVILEGES ON DATABASE postgres_reactive_ddd TO user_service;

-- Conceder permisos sobre todos los esquemas
GRANT USAGE ON SCHEMA public TO user_view;
GRANT USAGE ON SCHEMA public TO user_service;

-- Conceder permisos sobre todas las tablas existentes y futuras en el esquema público
ALTER DEFAULT PRIVILEGES IN SCHEMA public GRANT SELECT, INSERT, UPDATE, DELETE ON TABLES TO user_view;
ALTER DEFAULT PRIVILEGES IN SCHEMA public GRANT SELECT, INSERT, UPDATE, DELETE ON TABLES TO user_service;

-- Conceder permisos sobre todas las secuencias existentes y futuras en el esquema público
ALTER DEFAULT PRIVILEGES IN SCHEMA public GRANT USAGE, SELECT ON SEQUENCES TO user_view;
ALTER DEFAULT PRIVILEGES IN SCHEMA public GRANT USAGE, SELECT ON SEQUENCES TO user_service;

-- Conceder permisos sobre todas las funciones existentes y futuras en el esquema público
ALTER DEFAULT PRIVILEGES IN SCHEMA public GRANT EXECUTE ON FUNCTIONS TO user_view;
ALTER DEFAULT PRIVILEGES IN SCHEMA public GRANT EXECUTE ON FUNCTIONS TO user_service;

-- Conceder permisos sobre todas las tablas actuales en el esquema público
GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA public TO user_view;
GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA public TO user_service;

-- Conceder permisos sobre todas las secuencias actuales en el esquema público
GRANT USAGE, SELECT ON ALL SEQUENCES IN SCHEMA public TO user_view;
GRANT USAGE, SELECT ON ALL SEQUENCES IN SCHEMA public TO user_service;

-- Conceder permisos sobre todas las funciones actuales en el esquema público
GRANT EXECUTE ON ALL FUNCTIONS IN SCHEMA public TO user_view;
GRANT EXECUTE ON ALL FUNCTIONS IN SCHEMA public TO user_service;
