package intellimeet

import com.ig.intellimeet.QuestionTemplate
import com.ig.intellimeet.Survey
import com.ig.intellimeet.enums.SurveyType
import grails.rest.RestfulController

class SurveyApiController extends RestfulController<Survey>{

    static  responseFormats = ['json', 'xml']
    static allowedMethods = [create: "POST"]
    SurveyApiController(){
        super(Survey)
    }
    @Override
    def create(){
        println "-------------------------"
        println params
        if(Integer.parseInt(params.token?:"0")!=1){
            respond(response: "You are not authorized!")
            return false
        }
        switch (params.type?.toString()?.toLowerCase()){
            case "feedback": params.type = SurveyType.FEEDBACK; break
            case "session-preference": params.type = SurveyType.SESSION_PREFERENCE; break
            default: params.type = null
        }
        params.intelliMeetId = 1L
        params.date = new Date()
        params.questionTemplate = QuestionTemplate.get(1);
        Survey survey = createResource(params)
        if(survey.validate()){
            survey.save()
            redirect(controller: 'survey', action: 'show', params: [id:1])
        }
        else {
            respond(response: "Invalid data!")
        }
    }
}
