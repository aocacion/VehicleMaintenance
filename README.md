1	Introducción
Sistema que lleve el registro de mantenimiento de vehículo tanto del lado del dueño del vehículo como del lado del taller. El sistema debe tener configurado todas las tereas de mantenimiento del vehículo como por ejemplo cambio de aceite etc. de manera que se debe escoger entre este tipo de actividades. Además de eso, se debe llevar un control que avise al dueño del taller y del vehículo cuando es el próximo mantenimiento. EL proyecto debe ser en Spring Boot, microservicios, en aws usando base de datos relacionales MySQL, lambda, api rest y colas sns y sqs. 

2	Tecnologías a usar
•	Spring Boot
•	Microservicios en AWS
•	MySQL
•	Lambda
•	API REST
•	SNS/SQS.

3	Arquitectura Propuesta para el MVP
3.1.1	Componentes principales
El sistema estará compuesto por los siguientes microservicios:
•	Servicio de Usuarios: Gestión de usuarios (dueños de vehículos y talleres)
•	Servicio de Vehículos: Gestión de información de vehículos
•	Servicio de Mantenimiento: Catálogo de tareas de mantenimiento
•	Servicio de Registro de Servicios: Registro de mantenimientos realizados
•	Servicio de Notificaciones: Sistema de alertas para próximos mantenimientos
3.1.2	2. Infraestructura AWS
La arquitectura utilizará los siguientes servicios de AWS:
•	ECS/EKS: Para desplegar los microservicios contenerizados
•	RDS: MySQL para bases de datos relacionales
•	API Gateway: Para exponer APIs REST
•	Lambda: Para procesamiento de eventos
•	SNS/SQS: Para notificaciones y procesamiento asíncrono
•	CloudWatch: Para monitoreo y logging
