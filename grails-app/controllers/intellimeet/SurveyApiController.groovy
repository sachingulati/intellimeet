package intellimeet

import com.ig.intellimeet.Survey
import com.ig.intellimeet.enums.SurveyType
import grails.rest.RestfulController

class SurveyApiController extends RestfulController<Survey>{

    static  responseFormats = ['json', 'xml']
    SurveyApiController(){
        super(Survey)
    }
    @Override
    def create(){
        println params
        if(Integer.parseInt(params.token)!=1){
            respond(response: "You are not authorized!")
            return false
        }
        switch (params.type.toString().toLowerCase()){
            case "feedback": params.type = SurveyType.FEEDBACK; break
            case "session-preference": params.type = SurveyType.SESSION_PREFERENCE; break
            default: params.type = null
        }
        params.intelliMeetId = 1L
        params.date = new Date()
        Survey survey = createResource(params)
        if(survey.validate()){
            survey.save()
            respond(survey)
        }
        else {
            respond(response: "Invalid data!")
        }
    }
}
