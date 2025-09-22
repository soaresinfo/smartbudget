package com.soares.smartbudget.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.soares.smartbudget.AbstractIntegrationTest;
import com.soares.smartbudget.controller.model.TransactionRequestModel;
import com.soares.smartbudget.factory.TransactionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class SaveTransactionControllerIntegrationTest extends AbstractIntegrationTest {

    @Autowired
    private MockMvc mockMvc; // Injete o MockMvc

    @Autowired
    private ObjectMapper objectMapper; // Helper para converter objetos em JSON

    @Test
    @WithMockUser(username = "user", password = "password", roles = "USER") // Adicione um usuário mock para passar pela segurança
    void testSaveTransactionSuccess() throws Exception {
        // 1. Arrange (Preparação)
        TransactionRequestModel model = TransactionFactory.getModel();
        // O ID do expense precisa existir no seu data.sql de teste
        model.setIdExpense("c96adcca-00d5-49da-9261-dcbd0156d064");

        // 2. Act (Ação) & 3. Assert (Verificação)
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/transactions") // Simula o POST
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(model))) // Converte o objeto para JSON
                .andExpect(status().isCreated()) // Verifica se o status HTTP é 201 Created
                .andExpect(jsonPath("$.id_transaction").isNotEmpty()) // Verifica se o ID foi gerado
                .andExpect(jsonPath("$.description").value(model.getDescription()))
                .andExpect(jsonPath("$.value").value(model.getValue()))
                .andExpect(jsonPath("$.transaction_date").value(model.getTransactionDate()));
    }
}
