package com.santojes.ecommerce.customer.handler;

import java.util.Map;

public record ErrorResponse( //TODO: better error handling
        Map<String, String> erros
) {}
