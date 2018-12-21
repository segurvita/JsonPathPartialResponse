package com.segur.sample.endpoint;

import java.io.InputStream;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.io.IOUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.PathNotFoundException;

import lombok.var;

@Path("json-path")
public class JsonPathEndpoint {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMethod(@QueryParam("fields") String fields, @Context HttpHeaders headers) {

		try (InputStream _inputStream = this.getClass().getResourceAsStream("/sample.json")) {

			String _inputJson = IOUtils.toString(_inputStream, "UTF-8");

			String _outputJson = (fields == null || fields.length() == 0) ? _inputJson
					: this.filterFileds(_inputJson, fields);

			return Response.status(Response.Status.OK).entity(_outputJson).build();
		} catch (PathNotFoundException e) {
			e.printStackTrace();
			return Response.status(Response.Status.BAD_REQUEST).build();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}

	public String filterFileds(String inputJson, String fields) throws JsonProcessingException {

		var _outputObj = JsonPath.read(inputJson, fields);

		ObjectMapper _mapper = new ObjectMapper();

		return _mapper.writeValueAsString(_outputObj);
	}
}
