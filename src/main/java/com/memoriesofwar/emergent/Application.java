package com.memoriesofwar.emergent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import sx.blah.discord.api.ClientBuilder;
import sx.blah.discord.api.IDiscordClient;
import sx.blah.discord.util.DiscordException;

@SpringBootApplication
@EnableScheduling
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    private static String clientToken;

    @Value("${discord.CLIENT_TOKEN}")
    private void setClientToken(String ct) {
        clientToken = ct;
    }

    private static CommandHandler commandHandler;

    @Autowired
    private void setBasicCommandHandler(CommandHandler ch) {
        commandHandler = ch;
    }

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);

        // Discord4J stuff.
        IDiscordClient cli = createClient(clientToken, false);
        cli.getDispatcher().registerListener(commandHandler);
        cli.login();
    }

    public static IDiscordClient createClient(String token, boolean login) { // Returns a new instance of the Discord client
        ClientBuilder clientBuilder = new ClientBuilder(); // Creates the ClientBuilder instance
        clientBuilder.withToken(token); // Adds the login info to the builder

        try {
            if (login) {
                return clientBuilder.login(); // Creates the client instance and logs the client in
            } else {
                return clientBuilder.build(); // Creates the client instance but it doesn't log the client in yet, you would have to call client.login() yourself
            }
        } catch (DiscordException e) { // This is thrown if there was a problem building the client
            log.warn("WARNING - Discord4J :" + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    @Bean
    public CommandLineRunner run() throws Exception {
        return args -> {
            log.info("Application is now online.");
        };
    }
}