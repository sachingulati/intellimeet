<h1><a href="#">${topic?.name}</a>
</h1>
<p class="lead">created by <a href="#">${topic?.createdByUsername}</a>
</p>
<hr>
<p><span class="glyphicon glyphicon-time"></span> Posted on ${topic?.dateCreated?.format("EEE dd, yyyy 'at' hh:mm a")}</p>
<p></p><span class="glyphicon glyphicon-time"></span> Last updated on ${topic?.lastUpdated?.format("EEE dd, yyyy 'at' hh:mm a")}</p>
<hr>
%{--<img src="http://placehold.it/900x300" class="img-responsive">--}%
%{--<hr>--}%
<p>${topic?.description}</p>
<a class="btn btn-default" href="#"><span class="glyphicon glyphicon-thumbs-up"></span></a>
<a class="btn btn-default" href="#">Register as Presenter <span class="fa fa-sign-in"></span></a>
