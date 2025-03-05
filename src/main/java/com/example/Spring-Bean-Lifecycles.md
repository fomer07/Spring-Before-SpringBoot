# What is the Spring Bean Lifecycle ? 

Spring manages the lifecycle of beans in the container.The key stages include: 

**1. Bean Instantiation** - Spring creates the bean. 

**2. Dependency Injection** - Dependencies are injected.

**3. Initialization** - Custom logic can be executed using @PostConstruct.

**4. Usage** - The bean is used in the application.

**5. Destruction** - Cleanup can be performed using @PreDestroy before the bean is removed.
 