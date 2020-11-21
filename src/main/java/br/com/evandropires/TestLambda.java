package br.com.evandropires;

import javax.inject.Inject;
import javax.inject.Named;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import org.json.simple.JSONObject;

@Named("test")
public class TestLambda implements RequestHandler<InputObject, JSONObject> {

    @Inject
    ProcessingService service;

    @Override
    public JSONObject handleRequest(InputObject input, Context context) {
        OutputObject output = service.process(input).setRequestId(context.getAwsRequestId());

        JSONObject body = new JSONObject();
        body.put("result", output.getResult());
        body.put("requestId", output.getRequestId());

        JSONObject response = new JSONObject();
        response.put("statusCode", 200);
        response.put("body", body.toJSONString());
        return response;
    }
}
