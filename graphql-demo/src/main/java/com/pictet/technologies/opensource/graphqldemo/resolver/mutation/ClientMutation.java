package com.pictet.technologies.opensource.graphqldemo.resolver.mutation;

import com.pictet.technologies.opensource.graphqldemo.model.Client;
import com.pictet.technologies.opensource.graphqldemo.model.input.CreateClientInput;
import com.pictet.technologies.opensource.graphqldemo.repository.ClientRepository;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ClientMutation implements GraphQLMutationResolver {

    private final ClientRepository clientRepository;

    public Client createClient(CreateClientInput input) {
         return clientRepository.save(new Client().setName(input.getName()));
    }
}
