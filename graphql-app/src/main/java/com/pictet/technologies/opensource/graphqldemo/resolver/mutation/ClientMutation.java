package com.pictet.technologies.opensource.graphqldemo.resolver.mutation;

import com.pictet.technologies.opensource.graphqldemo.model.Client;
import com.pictet.technologies.opensource.graphqldemo.model.input.ClientInput;
import com.pictet.technologies.opensource.graphqldemo.repository.ClientRepository;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ClientMutation implements GraphQLMutationResolver {

    private final ClientRepository clientRepository;

    public Client createClient(ClientInput input) {
         return clientRepository.save(new Client()
             .setName(input.getName())
             .setAge(input.getAge()));
    }

    public Client updateClient(ClientInput input) {
        final Optional<Client> clientOptional = clientRepository.findById(input.getId());
        if (clientOptional.isPresent()) {
            Client client = clientOptional.get();
            client.setName(input.getName())
                    .setAge(input.getAge());
            clientRepository.save(client);
            return client;
        }
        return null;
    }

    public void deleteClient(ClientInput input) {
        clientRepository.deleteById(input.getId());
    }


}
