<?xml version="1.0" encoding="UTF-8"?>
<Configuration>
	<Appenders>
		<Console name="Console" target="SYSTEM_OUT">
			<PatternLayout
				pattern="%d{HH:mm:ss} [%t] %-5level %logger{36} - %msg%n" />
		</Console>
		<File name="File" fileName="target/mylog.log">
			<PatternLayout
				pattern="%d{HH:mm:ss} [%t] %-5level %logger{36} - %msg%n" />

		</File>
	</Appenders>
	<Loggers>
		<Root level="all">
			<AppenderRef ref="Console" level="all"></AppenderRef>
			<AppenderRef ref="File" level="error"></AppenderRef>
		</Root>
	</Loggers>
</Configuration>