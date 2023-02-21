package com.tucows.oxrs.epprtk.rtk.xml;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import org.junit.jupiter.api.Test;
import org.openrtk.idl.epprtk.epp_Exception;
import org.openrtk.idl.epprtk.domain.*;
import org.openrtk.idl.epprtk.epp_PollRsp;
import org.openrtk.idl.epprtk.epp_XMLException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;
import static org.junit.jupiter.api.Assertions.*;

@TestWithResources
class EPPPollTest {
    @GivenTextResource("poll/domain-infdata-poll-response.xml")
    String infDataPollResponseXml;

    @Test
    void pollWithDomainInfData() throws epp_XMLException, epp_Exception {
        EPPPoll poll = new EPPPoll(infDataPollResponseXml);
        epp_PollRsp pollRsp = poll.getResponseData();
        assertNotNull(pollRsp);
        assertNotNull(pollRsp.getResData(), "got poll resData");

        assertEquals("domain:infData", pollRsp.getResData().getType());
        assertInstanceOf(epp_DomainInfData.class, pollRsp.getResData());

        epp_DomainInfData infData = (epp_DomainInfData) pollRsp.getResData();
        assertEquals("example.pro", infData.getName());
        assertEquals("123456789-DONUTS", infData.getRoid());

        assertThat(infData.getStatus()).extracting("type", "value")
                .containsExactly(
                        tuple(epp_DomainStatusType.PENDING_DELETE, ""),
                        tuple(epp_DomainStatusType.SERVER_HOLD, "Compliance: Acceptable Use Policy")
                );

        assertEquals("reg-12345", infData.getRegistrant());

        assertThat(infData.getContacts()).extracting("type", "id")
                .containsExactly(
                        tuple(epp_DomainContactType.ADMIN, "admin-12345"),
                        tuple(epp_DomainContactType.TECH, "tech-12345"),
                        tuple(epp_DomainContactType.BILLING, "bill-12345")
                );

        assertThat(infData.getNameservers()).containsExactly("ns1.example.net", "ns2.example.net");

        assertEquals("2020-11-15T06:20:02.282Z", infData.getCreatedDate());
        assertEquals("2023-01-04T08:31:50.903Z", infData.getUpdatedDate());
        assertEquals("2022-11-15T06:20:02.282Z", infData.getExpirationDate());

        assertEquals("myclid-123", infData.getClientId());
        assertEquals("crclid-234", infData.getCreatedBy());
        assertEquals("crclid-234", infData.getUpdatedBy());

        assertNotNull(infData.getAuthInfo());
        assertEquals("hunter2", infData.getAuthInfo().getValue());
    }
}