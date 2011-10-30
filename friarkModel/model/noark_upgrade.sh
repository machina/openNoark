#!/bin/bash
sed -i -e s/MVCore:EMVCPackage/MVCore:Package/g $1
sed -i -e s/nsURI=\".*\"//g $1
sed -i -e s/nsPrefix=\".*\"//g $1
sed -i -e s/eSubpackages/subPackages/g $1
sed -i -e s/eClassifiers/members/g $1
sed -i -e s/EDomainClass/Domain/g $1
sed -i -e s/EControllerClass/Controller/g $1
sed -i -e "s/&#xA;/&amp;#xA;/g" $1


#sed -i -e s/eStructuralFeatures xsi:type=\"ecore:EReference\"/references/g
#sed -i -e s//references/g
groovy noark_upgrade_references.groovy $1
xmlstarlet fo noark5.mvcore > noark5_fo.mvcore && mv noark5_fo.mvcore noark5.mvcore
groovy noark_upgrade_attributes.groovy $1
xmlstarlet fo noark5.mvcore > noark5_fo.mvcore && mv noark5_fo.mvcore noark5.mvcore
groovy noark_upgrade_annotations.groovy $1

xmlstarlet fo noark5.mvcore > noark5_fo.mvcore && mv noark5_fo.mvcore noark5.mvcore

sed -i -e "s/eSuperTypes=\"\/\/.*\//super=\"\/\/@members[name='/g" $1
sed -i -e "s/super=\"\/\/@members\[name='\([A-Za-z]*\)\"/super=\"\/\/@members\[name=\'\1\'\]\"/g" $1

sed -i -e "s/\/\/@members/\/\/\\\\subPackages.0\/@members/g" $1

groovy noark_upgrade_actions.groovy $1
xmlstarlet fo noark5.mvcore > noark5_fo.mvcore && mv noark5_fo.mvcore noark5.mvcore

sed -i -e "s/--NEWLINE--/\&#xA;/g" $1

