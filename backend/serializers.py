from rest_framework import serializers 
from .models import User, Skin

class UserSerializer(serializers.ModelSerializer):
    class Meta:
        model = User 
        fields = "__all__"

class SkinSerializer(serializers.ModelSerializer):
    class Meta:
        model = Skin 
        fields = "__all__"
