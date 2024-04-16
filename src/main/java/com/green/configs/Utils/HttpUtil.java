//import org.json.JSONArray;
//import org.json.JSONObject;
//
//import org.springframework.http.*;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//import org.springframework.web.util.UriComponents;
//import org.springframework.web.util.UriComponentsBuilder;
//
//import java.util.ArrayList;
//
//@Service("httpUtil")
//public class HttpUtil {
//
//      //kakao Web 지도 API호출 및 주소 검증
//    public List<AddrUpdDto> verifyAddr(List<AddrUpdDto> list, String apiKey,String urlPath) throws Exception{
//        ///////////////////////////////////
//        //list : 주소검증 대상 데이터/////////
//        //accessKey  : 최종 api사용 데이터///
//        //urlPath : api주소////////////////
//        ///////////////////////////////////
//
//        //        결과값 리턴을 위한 객체리스트 선언
//        List<AddrUpdDto> errAddrList = new ArrayList<>();
//
//        //리스트 데이터를 받아 for문 내에서 각 데이터 검증
//        for (AddrUpdDto dto : list) {
//                String targetSaCode = dto.getSaCode();
//                try {
//                    //http 요청헤더설정
//                    HttpHeaders httpHeaders = new HttpHeaders();
//                    httpHeaders.set("Authorization", apiKey);
//                    HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
//                    UriComponents uriComponents = UriComponentsBuilder
//                            .fromHttpUrl(urlPath)
//                            .queryParam("query",dto.getAddress1())
//                            .build();
//
//                    //RestTemplate을 이용한 통신
//                    RestTemplate restTemplate = new RestTemplate();
//                    ResponseEntity<String> response = restTemplate.exchange(uriComponents.toString(), HttpMethod.GET, entity, String.class);
//
//                    //Res에서 필요정보 추출
//                    HttpStatus resCode = response.getStatusCode();
//                    //응답 코드가 200일 경우 작업진행
//                    if(resCode == HttpStatus.valueOf(200)) {
//                        String body = response.getBody();
//                        JSONObject json = new JSONObject(body);
//                        JSONArray documents = json.getJSONArray("documents");
//
//                        //검색결과가 없는 경우에는 app_err_addr테이블에 저장
//                        if(documents.toString().equals("[]")){
//                            errAddrList.add(dto);
//                        }
//                    } else{
//                        //응답코드가 200이 아닐경우
//                        logger.info(getClass()+"주소지 검증 중 오류 발생 : "+resCode);
//                    }
//                } catch (Exception e) {
//                    logger.info(getClass()+"주소지 검증 중 오류 발생 : "+targetSaCode);
//                }
//        }
//        return errAddrList;
//    }
//}
