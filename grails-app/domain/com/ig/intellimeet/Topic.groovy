package com.ig.intellimeet

import com.ig.intellimeet.embedded.TopicStatusInfo
import com.ig.intellimeet.enums.TopicCategory

class Topic {

    String name
    String description
    TopicCategory category
    Long createdBy

    List<String> expectations
    List<Long> interestedUsers
    List<TopicStatusInfo> statusInfoList
    List<String> tags

    Date dateCreated
    Date lastUpdated

    static final String SAMPLE_DESCRIPTION_TEMPLATE = """
As an attendee I would like to learn how to:
<ol>
<li>Do this</li>
<li>Do that</li>
</ol>
After attending this session I should be able to:
<ul>
<li>Do this</li>
<li>Do that</li>
</ul>
"""

    static mapWith = "mongo"

    static embedded = ['statusInfoList']

    static transients = ['createdByUsername', 'interestedUsersEmail']

    static constraints = {
        name blank: false
        description blank: false
    }

    static mapping = {
        description type: "text"
    }

    String getCreatedByUsername() {
        User.get(createdBy)?.username
    }

    List<String> getInterestedUsersEmail() {
        interestedUsers?.collect { User.get(it)?.username }
    }
}
