from django.shortcuts import render
from rest_framework import viewsets
from .serializers import SkinSerializer, UserSerializer
from .models import Skin, User

class UserView(viewsets.ModelViewSet):
    queryset = User.objects.all()
    serializer_class = UserSerializer

