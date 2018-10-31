package com.aifeii.nanohttpddemo.httpServer

import fi.iki.elonen.NanoHTTPD

/**
 * Created by AIfeiI on 2018/9/30.
 */
class NanoHttpdServer(hostname: String?, port: Int) : NanoHTTPD(hostname, port) {

    override fun serve(session: IHTTPSession?): Response {

        val files = HashMap<String, String>()

        val headers = session?.headers
        val method = session?.method
        val params = session?.parameters
        val queryParamsString = session?.queryParameterString
        val uri = session?.uri
        session?.parseBody(files)

        val out = "NanoHttpd ---> $method $uri \n" +
                "headers: $headers \n" +
                "params: $params \n" +
                "queryParamsString: $queryParamsString \n" +
                "files: $files \n" +
                "NanoHttpd <--- End"

        return newFixedLengthResponse(Response.Status.OK, NanoHTTPD.MIME_PLAINTEXT, out)
    }

}